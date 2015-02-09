package org.goots.jmh_benchmarks.hashmapswitch;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Benchmark)
@Warmup(iterations = 15)
@Measurement (iterations = 15)
public class EnumSwitchBenchmark
{
    @Param({"_non_existent", "_repository_id", "_get_policy", "operation"})
    public String value;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public boolean testEnum()
    {
        return Utils.SpecialOps.getSpecialOperation(value) != null;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public boolean testSwitch()
    {

        boolean result = false;

        switch (value)
        {
            case "_get_component":
            case "_repository_id":
            {
                result = true;
                break;
            }
            case "_interface":
            case "_non_existent":
            case "_set_policy_overrides":
            {
                result = true;
                break;
            }
            case "_get_policy":
            {
                result = true;
                break;
            }
        }
        return result;
    }

}
