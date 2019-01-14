(ns libreria.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [libreria.core-test]))

(doo-tests 'libreria.core-test)

