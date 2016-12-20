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
    int getColorBayer();
    String getCameraModel(int camIndex);

    boolean enableDarkSubtract(String bmpPath);
    void disableDarkSubtract();

    boolean isAvailable(int control);
    boolean isAutoSupported(int control);
    int getValue(int control, IntByReference pbAuto);
    int getMin(int control);
    int getMax(int control);
    void setValue(int control, int value, boolean autoSet);
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
    boolean setImageFormat(int width, int height, int binning, int imgType);
    ImgType getImgType();

    void startCapture();
    void stopCapture();

    boolean getImageData(byte[] buffer, int bufSize, int waitMs);
    void pulseGuide(int direction, int timeMs);

    void startExposure();
    int getExpStatus();
    boolean getImageAfterExp(byte[] buffer, int bufSize);
    void stopExposure();

    boolean isUSB3Host();
    boolean isCoolerCam();
    boolean getId(Pointer pID);
    boolean setId(String id);
    boolean isUSB3Camera();
    float getElectronsPerADU();
    void getGainOffset(IntByReference offsetHighestDR, IntByReference offsetUnityGain, IntByReference gainLowestRN, IntByReference offsteLowestRN);
}
