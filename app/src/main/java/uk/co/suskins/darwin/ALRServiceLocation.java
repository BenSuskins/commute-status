package uk.co.suskins.darwin;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.6.0.0
//
// Created by Quasar Development 
//
//---------------------------------------------------


import org.ksoap2.serialization.AttributeContainer;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class ALRServiceLocation extends AttributeContainer implements KvmSerializable {

    public String locationName;

    public String crs;

    public String via;

    public String futureChangeTo;

    public Boolean assocIsCancelled;

    private transient java.lang.Object __source;


    public void loadFromSoap(java.lang.Object paramObj, ALRExtendedSoapSerializationEnvelope __envelope) {
        if (paramObj == null)
            return;
        AttributeContainer inObj = (AttributeContainer) paramObj;
        __source = inObj;

        if (inObj instanceof SoapObject) {
            SoapObject soapObject = (SoapObject) inObj;
            int size = soapObject.getPropertyCount();
            for (int i0 = 0; i0 < size; i0++) {
                PropertyInfo info = soapObject.getPropertyInfo(i0);
                if (!loadProperty(info, soapObject, __envelope)) {
                }
            }
        }


    }


    protected boolean loadProperty(PropertyInfo info, SoapObject soapObject, ALRExtendedSoapSerializationEnvelope __envelope) {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("locationName")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.locationName = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.locationName = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("crs")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.crs = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.crs = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("via")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.via = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.via = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("futureChangeTo")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.futureChangeTo = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.futureChangeTo = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("assocIsCancelled")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.assocIsCancelled = new Boolean(j.toString());
                    }
                } else if (obj instanceof Boolean) {
                    this.assocIsCancelled = (Boolean) obj;
                }
            }
            return true;
        }
        return false;
    }

    public java.lang.Object getOriginalXmlSource() {
        return __source;
    }


    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return locationName;
        }
        if (propertyIndex == 1) {
            return crs;
        }
        if (propertyIndex == 2) {
            return this.via != null ? this.via : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 3) {
            return this.futureChangeTo != null ? this.futureChangeTo : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 4) {
            return this.assocIsCancelled != null ? this.assocIsCancelled : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "locationName";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "crs";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "via";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "futureChangeTo";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 4) {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "assocIsCancelled";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
