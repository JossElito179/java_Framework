package etu1773.framework;
import java.util.*;
import java.io.File;
import java.lang.reflect.*;

public class Utilitaire {
    
    public Utilitaire(){}

    public ArrayList<Class> findClassesInPackage(String path, String packageName) throws Exception {
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File directory=new File(path + "/" +packageName );
        System.out.println(directory);

        ArrayList<String> classNames = new ArrayList<>();
        ArrayList<Class> allClasses=new ArrayList<>();
        if (directory.exists()) {

            File[] files = directory.listFiles();
            for (File file : files) {
                String fileName = file.getName();
                if (fileName.endsWith(".java")) {
                    
                    String className =packageName+"."+fileName.substring(0, fileName.length() -5);
                    Class clazz = classLoader.loadClass(className);
                    allClasses.add(clazz);
                    classNames.add(clazz.getSimpleName());
                }
            }
        }else{
            System.out.println(" this file does not exist yet");
        }
       return allClasses;
    }

    public HashMap<String,Mapping> findAllAnnotatedMethods(ArrayList<Class> params){
        HashMap<String,Mapping> allMeth=new HashMap<String,Mapping>();
        for (Class para : params) {
            for (Method method : para.getDeclaredMethods()) {
                if (method.isAnnotationPresent(UrlAnnotation.class)) {
                    allMeth.put(method.getAnnotation(UrlAnnotation.class).Url(), new Mapping(para.getName(),method.getName()));
                }
            }   
        }
        return allMeth;
    }

}
