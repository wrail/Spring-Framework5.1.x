package proxy;
/*
 * @Author  Wrial
 * @Date Created in 13:44 2019/12/15
 * @Description 动态代理
 */

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtils {

	/**
	 *
	 * @return 返回一个代理对象
	 * 一个对象能被使用的步骤：内容->.java(io)->.class->new
	 */

	public static Object newInstance(Object target){
		Object proxy=null;
		Class<?> targetInf = target.getClass().getInterfaces()[0];
		Method methods[] =targetInf.getDeclaredMethods();
		String line="\n";
		String tab ="\t";
		String infName = targetInf.getSimpleName();
		String content ="";
		String packageContent = "package com.google;"+line;
		String importContent = "import "+targetInf.getName()+";"+line;
		String clazzFirstLineContent = "public class $Proxy implements "+infName+"{"+line;
		String filedContent  =tab+"private "+infName+" target;"+line;
		String constructorContent =tab+"public $Proxy ("+infName+" target){" +line
				+tab+tab+"this.target =target;"
				+line+tab+"}"+line;
		String methodContent = "";
		for (Method method : methods) {
			String returnTypeName = method.getReturnType().getSimpleName();
			String methodName =method.getName();
			// Sting.class String.class
			Class<?> args[] = method.getParameterTypes();
			String argsContent = "";
			String paramsContent="";
			int flag =0;
			for (Class<?> arg : args) {
				String temp = arg.getSimpleName();
				//String
				//String p0,Sting p1,
				argsContent+=temp+" p"+flag+",";
				paramsContent+="p"+flag+",";
				flag++;
			}
			if (argsContent.length()>0){
				argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
				paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
			}

			methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+") {"+line
					+tab+tab+"System.out.println(\"log\");"+line
					+tab+tab+"target."+methodName+"("+paramsContent+");"+line
					+tab+"}"+line;

		}

		content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";

		File file =new File("d:\\com\\google\\$Proxy.java");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();


			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

			StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
			Iterable units = fileMgr.getJavaFileObjects(file);

			JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,  units);
			t.call();
			fileMgr.close();

			URL[] urls = new URL[]{new URL("file:D:\\\\")};
			URLClassLoader urlClassLoader = new URLClassLoader(urls);
			Class<?> clazz = urlClassLoader.loadClass("com.google.$Proxy");

			Constructor<?> constructor = clazz.getConstructor(targetInf);

			proxy = constructor.newInstance(target);
			//clazz.newInstance();
			//Class.forName()
		}catch (Exception e){
			e.printStackTrace();
		}

		return proxy;
	}

	/*
	public static Object newProxyInstance(Class targetInterface) {

		Method[] methods = targetInterface.getDeclaredMethods(); //所有方法
		String line = "\n"; //换行
		String tab = "\t";
		String infName = targetInterface.getSimpleName(); //类名
		String content = ""; //内容
		String packageContent = "package com.google;" + line; //自定义一个包路径
		String importContent = targetInterface.getName() + ";" + line; //需要引入的包
		String clazzFirstLineContent = "public class $Proxy implement " + infName + " {" + line; //第一行
		String filedContent = tab + "private " + infName + " target;" + line;  //代理类的私有属性
		String constructorContent = "public $Proxy (" + infName + " target){" + line
				+ tab + tab + "this.target = target;" + line
				+ tab + "}" + line;

		String methodContent = "";
		for (Method method : methods) {
			String returnTypeName = method.getReturnType().getSimpleName();
			String methodName = method.getName();
			String argsContent = ""; //参数中全部内同  供编写方法体时使用
			String paramsContent = "";//参数的名字（无类型） 供调用方法的时候使用
			Class[] parameterTypes = method.getParameterTypes();

			if (parameterTypes.length > 0) {
				//遍历参数
				for (int i = 0; i < parameterTypes.length; i++) {
					String temp = parameterTypes[i].getSimpleName();
					argsContent += temp + " p" + i + ",";
					paramsContent += "p" + i + ",";
				}
				//去掉多余的逗号
				argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
				paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(",") - 1);
			}


			methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + line
					+ tab + tab + "System.out.println(\"log\");" + line
					+ tab + tab + "target." + methodName + "(" + paramsContent + ");" + line
					+ tab + "}"+line;
		}
		content = packageContent + importContent+ clazzFirstLineContent+ filedContent+constructorContent+methodContent+"}";

		File file = new File("d:\\com\\google\\$Proxy.java");
		try {
			if (!file.exists()){
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();
//			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//
//			StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
//			Iterable units = fileMgr.getJavaFileObjects(file);
//
//			JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
//			t.call();
//			fileMgr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}


		return null;
	}

*/

}
