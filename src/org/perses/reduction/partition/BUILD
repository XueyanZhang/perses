package(default_visibility = [
    "//src/org/perses/reduction:__subpackages__",
    "//test/org/perses:__subpackages__",
])

load("@io_bazel_rules_kotlin//kotlin:jvm.bzl", "kt_jvm_library")

kt_jvm_library(
    name = "partition",
    srcs = ["Partition.kt"],
    deps = [
        "//:guava",
        "//src/org/perses/spartree",
        "//src/org/perses/util",
    ],
)

java_library(
    name = "level_partition_policy",
    srcs = [
        "AbstractLevelPartitionPolicy.java",
        "SimpleLevelPartitionPolicy.java",
    ],
    deps = [
        ":partition",
        "//:guava",
        "//src/org/perses/reduction:reduction_level",
    ],
)
