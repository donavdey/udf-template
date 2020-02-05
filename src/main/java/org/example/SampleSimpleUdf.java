package org.example;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

@Description(
        name="SampleSimpleUdf",
        value="joins given text"
)
public class SampleSimpleUdf extends UDF {

    public String evaluate(String[] input) {
        return StringUtils.join(input);
    }

}
