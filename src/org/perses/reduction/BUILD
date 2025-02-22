package(default_visibility = [
    "//visibility:public",
])

load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "sorted_int_arrays",
    srcs = ["SortedIntArrayReference.kt"],
    deps = [
        "//:guava",
    ],
)

kt_jvm_library(
    name = "future_execution_result_triple",
    srcs = [
        "FutureExecutionResultInfo.kt",
    ],
    deps = [
        ":test_script_executor_service",
        "//src/org/perses/program",
        "//src/org/perses/spartree",
    ],
)

kt_jvm_library(
    name = "ListenableReductionState",
    srcs = [
        "ListenableReductionState.kt",
    ],
    deps = [
        "//:flogger",
        "//src/org/perses/util:perses_kt_exts",
    ],
)

kt_jvm_library(
    name = "tree_edit_with_its_program",
    srcs = ["TreeEditWithItsResult.kt"],
    deps = [
        ":test_script",
        "//src/org/perses/program",
        "//src/org/perses/spartree",
    ],
)

kt_jvm_library(
    name = "property_test_result",
    srcs = ["PropertyTestResult.kt"],
)

kt_jvm_library(
    name = "test_script",
    srcs = ["TestScript.kt"],
    deps = [
        ":property_test_result",
        "//:flogger",
        "//src/org/perses/program:source_file",
        "//src/org/perses/util",
        "//src/org/perses/util:shell",
        "//src/org/perses/util:timeutil",
        "@maven//:org_apache_commons_commons_exec",
    ],
)

kt_jvm_library(
    name = "reduction_level",
    srcs = ["ReductionLevel.kt"],
    deps = [
        "//:guava",
        "//src/org/perses/spartree",
        "//src/org/perses/util",
    ],
)

kt_jvm_library(
    name = "reduction_configuration",
    srcs = ["ReductionConfiguration.kt"],
    deps = [
        "//:guava",
        "//src/org/perses/antlr:parse_tree_with_parser",
        "//src/org/perses/grammar:facade_factory",
        "//src/org/perses/grammar:grammar_facade",
        "//src/org/perses/program",
        "//src/org/perses/program:language_kind",
        "//src/org/perses/reduction/io",
        "//src/org/perses/util",
        "//src/org/perses/util:timeutil",
        "@maven//:org_checkerframework_checker_qual",
    ],
)

kt_jvm_library(
    name = "actionset_profiler",
    srcs = ["AbstractActionSetProfiler.kt"],
    deps = [
        "//:guava",
        "//src/org/perses/spartree",
    ],
)

kt_jvm_library(
    name = "reducer_name_and_desc",
    srcs = ["AbstractReducerNameAndDesc.kt"],
)

kt_jvm_library(
    name = "reducer_context_interface",
    srcs = [
        "AbstractReducerContext.kt",
    ],
    deps = [
        ":test_script_executor_service",
        "//src/org/perses/reduction/io",
    ],
)

kt_jvm_library(
    name = "reducer_interface",
    srcs = [
        "AbstractReducer.kt",
    ],
    deps = [
        ":test_script_executor_service",
        "//src/org/perses/reduction/io",
    ],
)

kt_jvm_library(
    name = "abstract_reducer",
    srcs = [
        "AbstractReductionListener.kt",
        "AbstractTokenReducer.kt",
        "FixpointReductionState.kt",
        "ReducerAnnotation.kt",
        "ReducerContext.kt",
        "ReductionListenerManager.kt",
        "SparTreeWithParsability.kt",
    ],
    deps = [
        ":actionset_profiler",
        ":future_execution_result_triple",
        ":reducer_context_interface",
        ":reducer_interface",
        ":reducer_name_and_desc",
        ":reduction_configuration",
        ":test_script",
        ":test_script_executor_service",
        ":tree_edit_with_its_program",
        "//:guava",
        "//src/org/perses/delta",
        "//src/org/perses/program",
        "//src/org/perses/reduction/cache:query_cache",
        "//src/org/perses/reduction/event",
        "//src/org/perses/reduction/io/token:token_reduction_io_manager",
        "//src/org/perses/spartree",
        "//src/org/perses/util",
    ],
)

kt_jvm_library(
    name = "test_script_executor_service",
    srcs = [
        "TestScriptExecutorService.kt",
    ],
    deps = [
        ":test_script",
        "//:guava",
        "//src/org/perses/grammar:grammar_facade",
        "//src/org/perses/program",
        "//src/org/perses/reduction/cache:query_cache",
        "//src/org/perses/reduction/io",
        "//src/org/perses/util",
        "//src/org/perses/util:performance_monitor",
        "//src/org/perses/util:timeutil",
    ],
)

kt_jvm_library(
    name = "reducer_factory",
    srcs = ["ReducerFactory.kt"],
    deps = [
        ":abstract_reducer",
        ":reduction_configuration",
        ":test_script_executor_service",
        "//:guava",
        "//src/org/perses/reduction/reducer:node_based_reducer",
        "//src/org/perses/reduction/reducer/hdd:level_based_reducers",
        "//src/org/perses/reduction/reducer/token:token_slicer",
    ],
)

java_library(
    name = "reduction_level_sequence",
    srcs = ["IReductionLevelSequence.java"],
    deps = [
        "//:guava",
    ],
)

kt_jvm_library(
    name = "reduction_driver_interface",
    srcs = [
        "AbstractReductionDriver.kt",
        "IReductionDriver.kt",
    ],
    deps = [
        "//src/org/perses/reduction:test_script_executor_service",
        "//src/org/perses/reduction/io",
    ],
)

kt_jvm_library(
    name = "reduction_driver",
    srcs = [
        "AbstractProgramReductionDriver.kt",
        "RegularProgramReductionDriver.kt",
    ],
    deps = [
        ":abstract_reducer",
        ":actionset_profiler",
        ":reducer_factory",
        ":reduction_configuration",
        ":reduction_driver_interface",
        ":test_script_executor_service",
        "//:flogger",
        "//:guava",
        "//src/org/perses:command_options",
        "//src/org/perses/antlr:antlr_hierarchy",
        "//src/org/perses/grammar:grammar_facade",
        "//src/org/perses/listener:listeners",
        "//src/org/perses/program",
        "//src/org/perses/reduction/cache:enum_query_caching_control",
        "//src/org/perses/reduction/cache:query_cache",
        "//src/org/perses/reduction/cache:query_cache_factory",
        "//src/org/perses/reduction/cache:query_cache_memory_profiler",
        "//src/org/perses/reduction/cache:query_cache_profiler",
        "//src/org/perses/reduction/io/token:regular_output_manager_factory",
        "//src/org/perses/reduction/io/token:token_output_manager_factory_interface",
        "//src/org/perses/reduction/io/token:token_reduction_io_manager",
        "//src/org/perses/spartree",
        "//src/org/perses/util",
        "//src/org/perses/util:timeutil",
        "@maven//:org_antlr_antlr4",
        "@maven//:org_antlr_antlr4_runtime",
        "@maven//:org_checkerframework_checker_qual",
    ],
)
