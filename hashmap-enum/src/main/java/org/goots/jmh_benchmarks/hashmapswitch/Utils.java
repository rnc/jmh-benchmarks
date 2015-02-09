package org.goots.jmh_benchmarks.hashmapswitch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nick Cross on 08/02/15.
 */
public class Utils
{

    /**
     * Enumeration to represent special operations which are handled by stubs
     */
    static enum SpecialOps
    {
        IS_A("_is_a"),
        /**
         * See org.jacorb.orb.Delegate.get_interface_def
         */
        INTERFACE("_interface"),
        GET_POLICY("_get_policy"),
        NON_EXISTENT("_non_existent"),
        GET_COMPONENT("_get_component"),
        REPO_ID("_repository_id"),
        SET_POLICY("_set_policy_overrides");

        private final String operation;

        private static final Map<String, SpecialOps> map = new HashMap<>(8);

        static SpecialOps getSpecialOperation (String cf)
        {
            return map.get(cf);
        }

        SpecialOps(String operation)
        {
            this.operation = operation;
        }

        public String toString()
        {
            return operation;
        }
    }

    static
    {
        for (SpecialOps type : SpecialOps.values())
        {
            SpecialOps.map.put(type.operation, type);
        }
    }

}
