package me.fbiflow.celestialcore.core.space.object.naming;

public class SpaceObjectSignature {

    public final Constants.Class clazz;
    public final Constants.Origin origin;
    public final Constants.Core core;
    public final Constants.Modifier modifier;

    public SpaceObjectSignature(Constants.Class clazz, Constants.Origin origin, Constants.Core core, Constants.Modifier modifier) {
        this.clazz = clazz;
        this.origin = origin;
        this.core = core;
        this.modifier = modifier;
    }

    public static void main(String[] args) {
        var sign = new SpaceObjectSignature(Constants.Class.ST, Constants.Origin.NAT, Constants.Core.GAMMA, Constants.Modifier.PR);
        System.out.println(sign);
        System.out.println(sign.description());
    }

    public static final class Constants {

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

    @Override
    public String toString() {
        return String.format("[%s]-[%s]:[%s]-[%s]", clazz, origin, core, modifier);
    }

    public String description() {
        return String.format("[%s]-[%s]:[%s]-[%s]", clazz.type, origin.type, core, modifier.type);
    }

}