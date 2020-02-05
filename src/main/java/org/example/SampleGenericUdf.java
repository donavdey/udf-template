package org.example;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.MapObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SampleGenericUdf extends GenericUDF {

    private ObjectInspector[] inputOIs;
    private ObjectInspector outputOI;

    @Override
    public ObjectInspector initialize(ObjectInspector[] ois) throws UDFArgumentException {
        this.inputOIs = ois;
        this.outputOI = ObjectInspectorFactory.getStandardListObjectInspector(
                PrimitiveObjectInspectorFactory.javaStringObjectInspector); // TODO: replace with your return type object inspector
        return outputOI;
    }

    public Object evaluate(DeferredObject[] args) throws HiveException {
        List<String> results = new ArrayList<String>();
        Map<?, ?> inputMap = ((MapObjectInspector) inputOIs[0]).getMap(args[0].get());

        for (Object element : inputMap.values()) {
            results.add(element.toString());
        }

        return results;
    }

    @Override
    public String getDisplayString(String[] args) {
        return SampleGenericUdf.class.getName();
    }

}
