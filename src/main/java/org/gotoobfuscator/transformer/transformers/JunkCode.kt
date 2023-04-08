package org.gotoobfuscator.transformer.transformers

import org.gotoobfuscator.Obfuscator
import org.gotoobfuscator.dictionary.impl.UnicodeDictionary
import org.gotoobfuscator.transformer.Transformer
import org.gotoobfuscator.utils.ASMUtils
import org.gotoobfuscator.utils.InstructionModifier
import org.gotoobfuscator.utils.RandomUtils
import org.objectweb.asm.Handle
import org.objectweb.asm.Type
import org.objectweb.asm.tree.*
import java.util.concurrent.ThreadLocalRandom

class JunkCode : Transformer("JunkCode") {
    private val repeat = "${RandomUtils.randomStringByStringList(4,UnicodeDictionary.arabic)}\n".repeat(ThreadLocalRandom.current().nextInt(100,200))
    private val repeatType = "[".repeat(255)

    private var handleMethods = 0

    @Suppress("SpellCheckingInspection")
    override fun transform(node: ClassNode) {
        if (ASMUtils.isInterfaceClass(node)) return

        for (method in node.methods) {
            if (ASMUtils.isSpecialMethod(method)) continue
            if (method.name == "<init>") continue

            val modifier = InstructionModifier()

            for (instruction in method.instructions) {
                if (instruction is LabelNode) {
                    if (method.instructions.indexOf(instruction) == method.instructions.size() - 1) continue

                    val label = LabelNode()

                    val list = InsnList().apply {
                        add(label)
                        add(ASMUtils.createNumberNode(ThreadLocalRandom.current().nextInt(0, Int.MAX_VALUE)))
                        add(JumpInsnNode(IFGE, instruction))

                        add(InsnNode(ACONST_NULL))
                        add(TypeInsnNode(CHECKCAST,"${repeatType}L;"))
                        add(MethodInsnNode(INVOKESTATIC,repeat,repeat,"(${repeatType}L;)V",false))
                    }

                    modifier.prepend(instruction,list)
                }
            }

            modifier.apply(method)

            handleMethods++
        }
    }

    override fun finish(obfuscator : Obfuscator) {
        print("Handled $handleMethods methods")
    }
}