(ns app.views
  (:require [re-frame.core :as rf]))

(defn app
  []
  (let [counter @(rf/subscribe [:counter])]
   [:div
    [:h1 "A template for re-frame apps"]
    [:button
     {:on-click #(rf/dispatch [:decrement])}
     "-"]
    [:button {:disabled true} counter]
    [:button 
     {:on-click #(rf/dispatch [:increment])}
     "+"]]))
