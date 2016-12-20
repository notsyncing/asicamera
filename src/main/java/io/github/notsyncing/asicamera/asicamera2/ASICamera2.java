package io.github.notsyncing.asicamera.asicamera2;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

public interface ASICamera2 extends Library
{
    ASICamera2 instance = (ASICamera2) Native.loadLibrary("ASICamera2", ASICamera2.class);

    int asiGetNumOfConnectedCameras();
    int asiGetProductIDs(int[] pPIDs);
    int asiGetCameraProperty(ASICameraInfo.ByReference pASICameraInfo, int iCameraIndex);
    int asiOpenCamera(int iCameraId);
    int asiInitCamera(int iCameraId);
    int asiCloseCamera(int iCameraId);
    int asiGetNumOfControls(int iCameraId, IntByReference piNumberOfControls);
    int asiGetControlCaps(int iCameraId, int iControlIndex, ASIControlCaps.ByReference pControlCaps);
    int asiGetControlValue(int iCameraId, int controlType, LongByReference plValue,
                                    IntByReference pbAuto);
    int asiSetControlValue(int iCameraId, int controlType, long lValue, IntByReference bAuto);
    int asiSetROIFormat(int iCameraId, int iWidth, int iHeight, int iBin, int imgType);
    int asiGetROIFormat(int iCameraId, IntByReference piWidth, IntByReference piHeight, IntByReference piBin,
                                 IntByReference imgType);
    int asiSetStartPos(int iCameraId, int iStartX, int iStartY);
    int asiGetStartPos(int iCameraId, IntByReference piStartX, IntByReference piStartY);
    int asiGetDroppedFrames(int iCameraId, IntByReference piDropFrames);
    int asiEnableDarkSubtract(int iCameraId, String pcBMPPath);
    int asiDisableDarkSubtract(int iCameraId);
    int asiStartVideoCapture(int iCameraId);
    int asiStopVideoCapture(int iCameraId);
    int asiGetVideoData(int iCameraId, byte[] pBuffer, long lBuffSize, int iWaitMs);
    int asiPulseGuideOn(int iCameraId, int direction);
    int asiPulseGuideOff(int iCameraId, int directions);
    int asiStartExposure(int iCameraId, int bIsDark);
    int asiStopExposure(int iCameraId);
    int asiGetExpStatus(int iCameraId, IntByReference pExpStatus);
    int asiGetDataAfterExp(int iCameraId, byte[] pBuffer, long lBuffSize);
    int asiGetId(int iCameraId, Pointer pId);
    int asiSetId(int iCameraId, String id);
    int asiGetGainOffset(int iCameraId, IntByReference offsetHighestDR, IntByReference offsetUnityGain,
                                  IntByReference gainLowestRN, IntByReference offsetLowestRN);
}
