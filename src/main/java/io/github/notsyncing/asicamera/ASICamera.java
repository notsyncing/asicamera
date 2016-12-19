package io.github.notsyncing.asicamera;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

import java.io.IOException;

public interface ASICamera extends Library
{
    ASICamera instance = (ASICamera) Native.loadLibrary("ASICamera", ASICamera.class);

    int getNumberOfConnectedCameras();
    boolean openCamera(int camIndex);
    boolean initCamera();
    void closeCamera();
    boolean isColorCam();
    double getPixelSize();
    BayerPattern getColorBayer();
    String getCameraModel(int camIndex);

    boolean enableDarkSubtract(String bmpPath);
    void disableDarkSubtract();

    boolean isAvailable(ControlType control);
    boolean isAutoSupported(ControlType control);
    int getValue(ControlType control, IntByReference pbAuto);
    int getMin(ControlType control);
    int getMax(ControlType control);
    void setValue(ControlType control, int value, boolean autoSet);
    void setAutoPara(int iMaxGain, int iMaxExp, int iDestBrightness);
    void getAutoPara(IntByReference pMaxGain, IntByReference pMaxExp, IntByReference pDestBrightness);

    int getMaxWidth();
    int getMaxHeight();
    int getWidth();
    int getHeight();
    int getStartX();
    int getStartY();

    float getSensorTemp();
    long getDroppedFrames();
    boolean setMisc(boolean bFlipRow, boolean bFlipColumn);
    void getMisc(IntByReference pbFlipRow, IntByReference pbFlipColumn);

    boolean isBinSupported(int binning);
    boolean isImgTypeSupported(ImgType imgType);
    int getBin();

    boolean setStartPos(int startX, int startY);
    boolean setImageFormat(int width, int height, int binning, ImgType imgType);
    ImgType getImgType();

    void startCapture();
    void stopCapture();

    boolean getImageData(Pointer buffer, int bufSize, int waitMs);
    void pulseGuide(GuideDirections direction, int timeMs);

    void startExposure();
    ExposureStatus getExpStatus();
    boolean getImageAfterExp(Pointer buffer, int bufSize);
    void stopExposure();

    boolean isUSB3Host();
    boolean isCoolerCam();
    boolean getId(Pointer pID);
    boolean setId(String id);
    boolean isUSB3Camera();
    float getElectronsPerADU();
    void getGainOffset(IntByReference offsetHighestDR, IntByReference offsetUnityGain, IntByReference gainLowestRN, IntByReference offsteLowestRN);
}
