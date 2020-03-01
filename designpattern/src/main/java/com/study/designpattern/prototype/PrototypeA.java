package com.study.designpattern.prototype;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.*;
import java.util.List;
import java.util.Map;

@Data
public class PrototypeA implements IPrototype,Cloneable,Serializable {

    private Long id;
    private String name;
    private List<String> hobbes;
    private Map<String,String> map;

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object deepSerializableClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois =new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object deepJsonClone() {
        String json = JSONObject.toJSONString(this);
        return JSONObject.parseObject(json,this.getClass());
    }
}
