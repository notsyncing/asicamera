package io.github.notsyncing.asicamera.asicamera2;

import com.sun.jna.Structure;
import io.github.notsyncing.asicamera.ControlType;

import java.util.Arrays;
import java.util.List;

public class ASIControlCaps extends Structure {
    public String name;
    public String description;
    public long maxValue;
    public long minValue;
    public long defaultValue;
    public boolean isAutoSupported;
    public boolean isWritable;
    public ControlType controlType;
    public String unused;

    @Override
    protected List getFieldOrder()
    {
        return Arrays.asList("name", "description", "maxValue", "minValue", "defaultValue", "isAutoSupported",
                "isWritable", "controlType", "unused");
    }
}
