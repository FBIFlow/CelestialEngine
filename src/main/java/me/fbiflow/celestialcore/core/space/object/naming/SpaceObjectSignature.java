package me.fbiflow.celestialcore.core.space.object.naming;

import me.fbiflow.celestialcore.core.space.object.naming.constants.SignatureConstant;

public class SpaceObjectSignature {

    public final SignatureConstant.Class clazz;
    public final SignatureConstant.Origin origin;
    public final SignatureConstant.Core core;
    public final SignatureConstant.Modifier modifier;

    public SpaceObjectSignature(SignatureConstant.Class clazz, SignatureConstant.Origin origin, SignatureConstant.Core core, SignatureConstant.Modifier modifier) {
        this.clazz = clazz;
        this.origin = origin;
        this.core = core;
        this.modifier = modifier;
    }

    public static void main(String[] args) {
        var sign = new SpaceObjectSignature(SignatureConstant.Class.ST, SignatureConstant.Origin.NAT, SignatureConstant.Core.GAMMA, SignatureConstant.Modifier.PR);
        System.out.println(sign);
        System.out.println(sign.description());
    }

    @Override
    public String toString() {
        return String.format("[%s]-[%s]:[%s]-[%s]", clazz, origin, core, modifier);
    }

    public String description() {
        return String.format("[%s]-[%s]:[%s]-[%s]", clazz.type, origin.type, core, modifier.type);
    }

}