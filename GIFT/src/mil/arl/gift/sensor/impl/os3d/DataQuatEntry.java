/**
 * Copyright Dignitas Technologies, LLC
 * 
 * This file and its contents are governed by one or more distribution and
 * copyright statements as described in the LICENSE.txt file distributed with
 * this work.
 */
package mil.arl.gift.sensor.impl.os3d;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import com.sun.jna.Union;

/**
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a
 * href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few
 * opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a
 * href="http://rococoa.dev.java.net/">Rococoa</a>, or <a
 * href="http://jna.dev.java.net/">JNA</a>
 */
@SuppressWarnings("all")
public class DataQuatEntry extends Union {

    // / C type : field1_struct
    public field1_struct field1;
    // / C type : double[5]
    public double[] dQ = new double[5];

    // / <i>native declaration : line 28</i>
    // / <i>native declaration : line 28</i>
    public static class field1_struct extends Structure {
        public double dX;
        public double dY;
        public double dZ;
        public double dW;
        public double dReserved;

        public field1_struct() {
            super();
        }

        protected List<String> getFieldOrder() {
            return Arrays.asList("dX", "dY", "dZ", "dW", "dReserved");
        }

        public field1_struct(double dX, double dY, double dZ, double dW,
                double dReserved) {
            super();
            this.dX = dX;
            this.dY = dY;
            this.dZ = dZ;
            this.dW = dW;
            this.dReserved = dReserved;
        }

        public static class ByReference extends field1_struct implements
                Structure.ByReference {

        };

        public static class ByValue extends field1_struct implements
                Structure.ByValue {

        };
    };

    public DataQuatEntry() {
        super();
    }

    // / @param dQ C type : double[5]
    public DataQuatEntry(double dQ[]) {
        super();
        if (dQ.length != this.dQ.length)
            throw new IllegalArgumentException("Wrong array size !");
        this.dQ = dQ;
        setType(double[].class);
    }

    // / @param field1 C type : field1_struct
    public DataQuatEntry(field1_struct field1) {
        super();
        this.field1 = field1;
        setType(field1_struct.class);
    }

    public static class ByReference extends DataQuatEntry implements
            Structure.ByReference {

    };

    public static class ByValue extends DataQuatEntry implements
            Structure.ByValue {

    };
}
