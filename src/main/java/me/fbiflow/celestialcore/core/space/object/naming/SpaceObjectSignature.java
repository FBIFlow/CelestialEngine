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
            GAMMA,
            DELTA,
            EPSILON,
            ZETA,
            ETA,
            THETA,
            IOTA,
            KAPPA,
            LAMBDA,
            MU,
            NU,
            XI,
            OMICRON,
            PI,
            RHO,
            SIGMA,
            TAU,
            UPSILON,
            PHI,
            CHI,
            PSI,
            OMEGA

        }

        public enum Modifier {

            DR("Dying"),
            EC("Echo"),
            MN("Minor"),
            PR("Prime"),
            RG("Rogue"),
            SH("Shattered"),
            VC("Void Core"),
            WT("Wasteland");

            public final String type;

            Modifier(String type) {
                this.type = type;
            }
        }

    }


}