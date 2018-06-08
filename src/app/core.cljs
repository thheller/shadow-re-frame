(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.events] ;; These two are required so that 
            [app.subs]   ;; the compailer loads them
            [app.views]))

(rf/dispatch-sync [:initialise-db])

(defn ^:export main
  []
  (r/render [app.views/app]
            (.getElementById js/document "app")))