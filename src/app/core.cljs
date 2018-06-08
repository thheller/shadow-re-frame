(ns app.core
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [app.routes :as routes]
            [app.events] ;; These two are required so that 
            [app.subs]   ;; the compailer loads them
            [app.views :as views]))

(defn ^:export main
  []
  (routes/app-routes)
  (rf/dispatch-sync [:initialise-db])
  (r/render [views/app]
            (.getElementById js/document "app")))