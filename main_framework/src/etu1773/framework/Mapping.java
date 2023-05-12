package etu1773.framework;

public class Mapping {


    public String className;
    public String method;
    
    public Mapping() {
        System.out.println("Hello");
    }

    public Mapping(String className, String method) {
        this.className = className;
        this.method = method;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }


    
}
