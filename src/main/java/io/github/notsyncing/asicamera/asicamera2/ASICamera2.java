package io.github.notsyncing.asicamera.asicamera2;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import io.github.notsyncing.asicamera.ControlType;
import io.github.notsyncing.asicamera.ExposureStatus;
import io.github.notsyncing.asicamera.GuideDirections;
import io.github.notsyncing.asicamera.ImgType;

public interface ASICamera2 extends Library
{
    ASICamera2 instance = (ASICamera2) Native.loadLibrary("ASICamera2", ASICamera2.class);

    int asiGetNumOfConnectedCameras();
    int asiGetProductIDs(int[] pPIDs);
    ASIErrorCode asiGetCameraProperty(ASICameraInfo.ByReference pASICameraInfo, int iCameraIndex);
    ASIErrorCode asiOpenCamera(int iCameraId);
    ASIErrorCode asiInitCamera(int iCameraId);
    ASIErrorCode asiCloseCamera(int iCameraId);
    ASIErrorCode asiGetNumOfControls(int iCameraId, IntByReference piNumberOfControls);
    ASIErrorCode asiGetControlCaps(int iCameraId, int iControlIndex, ASIControlCaps.ByReference pControlCaps);
    ASIErrorCode asiGetControlValue(int iCameraId, ControlType controlType, LongByReference plValue,
                                    IntByReference pbAuto);
    ASIErrorCode asiSetControlValue(int iCameraId, ControlType controlType, long lValue, IntByReference bAuto);
    ASIErrorCode asiSetROIFormat(int iCameraId, int iWidth, int iHeight, int iBin, int imgType);
    ASIErrorCode asiGetROIFormat(int iCameraId, IntByReference piWidth, IntByReference piHeight, IntByReference piBin,
                                 IntByReference imgType);
    ASIErrorCode asiSetStartPos(int iCameraId, int iStartX, int iStartY);
    ASIErrorCode asiGetStartPos(int iCameraId, IntByReference piStartX, IntByReference piStartY);
    ASIErrorCode asiGetDroppedFrames(int iCameraId, IntByReference piDropFrames);
    ASIErrorCode asiEnableDarkSubtract(int iCameraId, String pcBMPPath);
    ASIErrorCode asiDisableDarkSubtract(int iCameraId);
    ASIErrorCode asiStartVideoCapture(int iCameraId);
    ASIErrorCode asiStopVideoCapture(int iCameraId);
    ASIErrorCode asiGetVideoData(int iCameraId, Pointer pBuffer, long lBuffSize, int iWaitMs);
    ASIErrorCode asiPulseGuideOn(int iCameraId, GuideDirections direction);
    ASIErrorCode asiPulseGuideOff(int iCameraId, GuideDirections directions);
    ASIErrorCode asiStartExposure(int iCameraId, int bIsDark);
    ASIErrorCode asiStopExposure(int iCameraId);
    ASIErrorCode asiGetExpStatus(int iCameraId, IntByReference pExpStatus);
    ASIErrorCode asiGetDataAfterExp(int iCameraId, Pointer pBuffer, long lBuffSize);
    ASIErrorCode asiGetId(int iCameraId, Pointer pId);
    ASIErrorCode asiSetId(int iCameraId, String id);
    ASIErrorCode asiGetGainOffset(int iCameraId, IntByReference offsetHighestDR, IntByReference offsetUnityGain,
                                  IntByReference gainLowestRN, IntByReference offsetLowestRN);
}
