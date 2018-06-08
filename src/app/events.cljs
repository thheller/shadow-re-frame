(ns app.events
  (:require
   [app.db :refer [app-db]]
   [re-frame.core :as rf]))

(rf/reg-event-fx
 :initialise-db
 (fn [_ _]
  {:db app-db}))

(rf/reg-event-db
 :increment
 (fn [db _]
    (update db :counter inc)))

(rf/reg-event-db
 :decrement
 (fn [db _]
    (update db :counter dec)))
