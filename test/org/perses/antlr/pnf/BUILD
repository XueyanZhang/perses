load("//antlropt/src/org/perses/antlr/pnf:pnf.bzl", "pnf_convert")
load("//test/org/perses:test.bzl", "golden_test")
load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library", "kt_jvm_test")

DEFAULT_DEPS = [
    "//src/org/perses/antlr:antlr_grammar_parser",
    "//antlropt/src/org/perses/antlr/ast:ast",
    "//antlropt/src/org/perses/antlr/pnf:pnf",
    "//src/org/perses/grammar/c:optc_parser_facade",
    "//src/org/perses/grammar/java:parser_facade",
    "//test/org/perses:test_util",
    "//:guava",
    "//:truth",
    "@maven//:org_antlr_antlr4",
    "@maven//:org_jgrapht_jgrapht_core",
    "//test/org/perses/antlr:GrammarTestingUtility",
    "//src/org/perses/util:file_name_content_pair",
]

DEFAULT_TEST_DEPS = DEFAULT_DEPS + [":PnfTestGrammar"]

kt_jvm_library(
    name = "PnfTestGrammar",
    srcs = [
        "PnfLeftTestGrammar.kt",
        "PnfRightTestGrammar.kt",
    ],
    data = ["//test_data/antlr_grammars"],
    visibility = [
        "//antlropt/test:__subpackages__",
    ],
    deps = DEFAULT_DEPS,
)

kt_jvm_test(
    name = "AltRulesInlinePassTest",
    srcs = ["AltRulesInlinePassTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

kt_jvm_test(
    name = "DuplicateRuleEliminationPassTest",
    srcs = ["DuplicateRuleEliminationPassTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

kt_jvm_test(
    name = "InlineSingleUseAltRulePassTest",
    srcs = ["InlineSingleUseAltRulePassTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

kt_jvm_test(
    name = "OptionalIntroducerPassTest",
    srcs = ["OptionalIntroducerPassTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

kt_jvm_test(
    name = "EliminateUnreachableRulePassTest",
    srcs = ["EliminateUnreachableRulePassTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

kt_jvm_test(
    name = "RuleTransitionGraphTest",
    srcs = ["RuleTransitionGraphTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

kt_jvm_test(
    name = "RuleDefMapTest",
    srcs = ["RuleDefMapTest.kt"],
    data = ["//test_data/antlr_grammars"],
    deps = DEFAULT_TEST_DEPS,
)

java_binary(
    name = "DumpPnfPassManagerLog",
    srcs = ["DumpPnfPassManagerLog.java"],
    jvm_flags = ["-ea"],
    main_class = "org.perses.antlr.pnf.DumpPnfPassManagerLog",
    deps = DEFAULT_TEST_DEPS,
)

genrule(
    name = "dump_pnf_pass_manager_log",
    srcs = [],
    outs = [
        "pnf_pass_manager_log.txt",
        "dump_pnf_pass_manager_log_tool_output.txt",
    ],
    cmd = "$(location :DumpPnfPassManagerLog) $(location pnf_pass_manager_log.txt) > $(location dump_pnf_pass_manager_log_tool_output.txt) 2>&1",
    tools = [":DumpPnfPassManagerLog"],
)

golden_test(
    name = "test_pnf_pass_manager_log",
    golden_file = "golden_pnf_pass_manager_log.txt",
    test_file = "pnf_pass_manager_log.txt",
)
