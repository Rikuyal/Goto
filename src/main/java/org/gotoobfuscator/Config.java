package org.gotoobfuscator;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

final class Config {
    @SerializedName("InputFile")
    public String input = "";

    @SerializedName("OutputFile")
    public String output = "";

    @SerializedName("MainClass")
    public String mainClass = "";

    @SerializedName("ClassRenameDictionaryFile")
    public String classRenameDictionaryFile = "";

    @SerializedName("ClassRenamePackageName")
    public String classRenamePackageName = "";

    @SerializedName("Libraries")
    public List<String> libraries = Collections.emptyList();

    @SerializedName("ExtractZips")
    public List<String> extractZips = Collections.emptyList();

    @SerializedName("SkipClasses")
    public List<String> skipClasses = Collections.emptyList();

    @SerializedName("ExcludeClasses")
    public List<String> excludeClasses = Collections.emptyList();

    @SerializedName("ClassRenameExclude")
    public List<String> classRenameExclude = Collections.emptyList();

    @SerializedName("ClassRenameDictionaryMode")
    public int classRenameDictionaryMode = 0;

    @SerializedName("DictionaryRepeatTimeBase")
    public int dictionaryRepeatTimeBase = 1;

    @SerializedName("ThreadPoolSize")
    public int threadPoolSize = 5;

    @SerializedName("LoadLibMode")
    public int libMode = 0;

    @SerializedName("MultiThreadLoadLibraries")
    public boolean multiThreadLoadLibraries = true;

    @SerializedName("PreVerify")
    public boolean preVerify = true;

    @SerializedName("ClassRenameRemoveMetadata")
    public boolean classRenameRemoveMetadata = true;

    @SerializedName("CorruptCRC")
    public boolean corruptCRC;

    @SerializedName("CorruptDate")
    public boolean corruptDate;

    @SerializedName("ClassFolder")
    public boolean classFolder;

    @SerializedName("DuplicateResource")
    public boolean duplicateResource;

    @SerializedName("Packer")
    public boolean packerEnable;

    @SerializedName("ConstantPacker")
    public boolean constantPackerEnable;

    @SerializedName("ExtractorMode")
    public boolean extractorMode;

    @SerializedName("UseComputeMaxs")
    public boolean useComputeMaxs;

    @SerializedName("ClassRename")
    public boolean classRenameEnable;

    @SerializedName("StringEncryptor")
    public boolean stringEncryptorEnable;

    @SerializedName("HideCode")
    public boolean hideCodeEnable;

    @SerializedName("NumberEncryptor")
    public boolean numberEncryptorEnable;

    @SerializedName("JunkCode")
    public boolean junkCodeEnable;

    @SerializedName("SourceRename")
    public boolean sourceRenameEnable;

    @SerializedName("BadAnnotation")
    public boolean badAnnotationEnable;

    @SerializedName("Crasher")
    public boolean crasherEnable;

    @SerializedName("InvalidSignature")
    public boolean invalidSignatureEnable;

    @SerializedName("VariableRename")
    public boolean variableRenameEnable;

    @SerializedName("InvokeProxy")
    public boolean invokeProxyEnable;

    @SerializedName("FlowObfuscation")
    public boolean flowObfuscationEnable;

    @SerializedName("FakeClasses")
    public boolean fakeClassesEnable;

    @SerializedName("DecompilerCrasher")
    public boolean decompilerCrasherEnable;

    public Config() {

    }
}
