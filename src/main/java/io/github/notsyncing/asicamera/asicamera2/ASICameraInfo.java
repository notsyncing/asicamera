package io.github.notsyncing.asicamera.asicamera2;

import com.sun.jna.Structure;
import io.github.notsyncing.asicamera.BayerPattern;

import java.util.Arrays;
import java.util.List;

public class ASICameraInfo extends Structure {
    public String name;
    public int cameraId;
    public long maxHeight;
    public long maxWidth;

    public boolean isColorCam;
    public BayerPattern bayerPattern;

    public int[] supportedBins;
    public int[] supportedVideoFormat;

    public double pixelSize;
    public boolean mechanicalShutter;
    public boolean st4Port;
    public boolean isCoolerCam;
    public boolean isUSB3Host;
    public boolean isUSB3Camera;
    public float elecPerADU;

    public String unused;

    @Override
    protected List getFieldOrder()
    {
        return Arrays.asList("name", "cameraId", "maxHeight", "maxWidth", "isColorCam", "bayerPattern", "supportedBins",
                "supportedVideoFormat", "pixelSize", "mechanicalShutter", "st4Port", "isCoolerCam", "isUSB3Host",
                "isUSB3Camera", "elecPerADU");
    }
}
