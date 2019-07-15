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

public class ALRBaseStationBoard extends AttributeContainer implements KvmSerializable {

    public java.util.Date generatedAt;

    public String locationName;

    public String crs;

    public String filterLocationName;

    public String filtercrs;

    public ALREnums.FilterType filterType;

    public ALRArrayOfNRCCMessages nrccMessages;

    public Boolean platformAvailable;

    public Boolean areServicesAvailable;

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
        if (info.name.equals("generatedAt")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.generatedAt = ALRHelper.ConvertFromWebService(j.toString());
                    }
                } else if (obj instanceof java.util.Date) {
                    this.generatedAt = (java.util.Date) obj;
                }
            }
            return true;
        }
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
        if (info.name.equals("filterLocationName")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.filterLocationName = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.filterLocationName = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("filtercrs")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.filtercrs = j.toString();
                    }
                } else if (obj instanceof String) {
                    this.filtercrs = (String) obj;
                }
            }
            return true;
        }
        if (info.name.equals("filterType")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.filterType = ALREnums.FilterType.fromString(j.toString());
                    }
                } else if (obj instanceof ALREnums.FilterType) {
                    this.filterType = (ALREnums.FilterType) obj;
                }
            }
            return true;
        }
        if (info.name.equals("nrccMessages")) {
            if (obj != null) {
                java.lang.Object j = obj;
                this.nrccMessages = (ALRArrayOfNRCCMessages) __envelope.get(j, ALRArrayOfNRCCMessages.class, false);
            }
            return true;
        }
        if (info.name.equals("platformAvailable")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.platformAvailable = new Boolean(j.toString());
                    }
                } else if (obj instanceof Boolean) {
                    this.platformAvailable = (Boolean) obj;
                }
            }
            return true;
        }
        if (info.name.equals("areServicesAvailable")) {
            if (obj != null) {
                if (obj.getClass().equals(SoapPrimitive.class)) {
                    SoapPrimitive j = (SoapPrimitive) obj;
                    if (j.toString() != null) {
                        this.areServicesAvailable = new Boolean(j.toString());
                    }
                } else if (obj instanceof Boolean) {
                    this.areServicesAvailable = (Boolean) obj;
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
            return this.generatedAt != null ? ALRHelper.getDateTimeFormat().format(this.generatedAt) : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return locationName;
        }
        if (propertyIndex == 2) {
            return crs;
        }
        if (propertyIndex == 3) {
            return this.filterLocationName != null ? this.filterLocationName : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 4) {
            return this.filtercrs != null ? this.filtercrs : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 5) {
            return this.filterType != null ? this.filterType.toString() : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 6) {
            return this.nrccMessages != null ? this.nrccMessages : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 7) {
            return this.platformAvailable != null ? this.platformAvailable : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 8) {
            return this.areServicesAvailable != null ? this.areServicesAvailable : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 9;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "generatedAt";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "locationName";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "crs";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "filterLocationName";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 4) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "filtercrs";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 5) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "filterType";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 6) {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "nrccMessages";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 7) {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "platformAvailable";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
        if (propertyIndex == 8) {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "areServicesAvailable";
            info.namespace = "http://thalesgroup.com/RTTI/2015-11-27/ldb/types";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }


}
