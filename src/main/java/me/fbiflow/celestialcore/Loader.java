package me.fbiflow.celestialcore;

import me.fbiflow.celestialcore.core.space.object.naming.SpaceObjectSignature;

public class Loader {

    public static void main(String[] args) {
        SpaceObjectSignature signature = new SpaceObjectSignature(
                SpaceObjectSignature.Constants.Class.AN,
                SpaceObjectSignature.Constants.Origin.ANC,
                SpaceObjectSignature.Constants.Core.ALPHA,
                SpaceObjectSignature.Constants.Modifier.DR
        );
    }

}
