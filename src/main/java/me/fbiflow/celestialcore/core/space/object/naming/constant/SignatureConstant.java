package me.fbiflow.celestialcore.core.space.object.naming.constant;

public class SignatureConstant {

    public enum Class {

        AN("Anomaly"),
        AS("Asteroid"),
        DR("Derelict"),
        MO("Lunar"),
        NB("Nebula"),
        PL("Planetary"),
        SN("Station"),
        ST("Stellar"),
        VO("Void");

        public final String type;

        Class(String type) {
            this.type = type;
        }

    }

    public enum Origin {

        ANC("Ancient"),
        ART("Artificial"),
        NAT("Natural"),
        TER("Terraformed"),
        UNK("Unknown"),
        VOI("Voidborn");

        public final String type;

        Origin(String type) {
            this.type = type;
        }
    }

    public enum Core {

        ALPHA,
        BETA,
        CHARLIE,
        DELTA,
        EPSILON,
        FOXTROT,
        GAMMA,
        HOTEL,
        IOTA,
        JULIET,
        KAPPA,
        LAMBDA,
        MIKE,
        NOVEMBER,
        OMEGA,
        PI,
        QUEBEC,
        RHO,
        SIGMA,
        TAU,
        UPSILON,
        VICTOR,
        WHISKEY,
        XRAY,
        YANKEE,
        ZETA


    }

    public enum Modifier {

        DR("Dying"),
        MN("Minor"),
        PR("Prime"),
        SH("Shattered");

        public final String type;

        Modifier(String type) {
            this.type = type;
        }
    }
}
