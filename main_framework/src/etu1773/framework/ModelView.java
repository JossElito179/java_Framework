package etu1773.framework;
import java.util.HashMap;
public class ModelView{
    public String view ;
    public HashMap<String,Object> data = new HashMap<>();

    public HashMap<String,Object> getData(){
        return data;
    }

    public void setData(HashMap<String,Object> newData){
        data=newData;
    }

    public void addItem(String key,Object value){
        data.put(key,value);
    }
}