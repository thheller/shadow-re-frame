(ns app.views
  (:require [re-frame.core :as rf]
            [app.routes :as routes]))

(defn header
  []
  [:div
   [:h1 "A template for re-frame apps"]
   [:div
    [:ul 
     [:li
      [:a {:href (routes/url-for :home)} "Home"]]
     [:li
      [:a {:href (routes/url-for :about)} "About"]]
     [:li 
      [:a {:href (routes/url-for :topics)} "Topics"]]]]])

(defn home
  []
  [:div "home"])
(defn about
  []
  [:div "about"])

(defn topics
  []
  [:div
   [:h2 "topics"]
   [:ol
    [:li
      [:a {:href (routes/url-for :topic :topic-id "cljs")} "ClojureScript"]]
    [:li
      [:a {:href (routes/url-for :topic :topic-id "clj")} "Clojure"]]]])

(defn topic
  [params]
  (let [topic-id @(rf/subscribe [:topic-id])]
   [:div
    [:h2 "topics"]
    [:ul
      [:li [:a {:href (routes/url-for :topics)} "back"]]
      [:li [:p topic-id]]]]))

(defn counter
  []
  (let [counter @(rf/subscribe [:counter])]
   [:div
    [:button
     {:on-click #(rf/dispatch [:decrement])}
     "-"]
    [:button {:disabled true} counter]
    [:button 
     {:on-click #(rf/dispatch [:increment])}
     "+"]]))

(defn pages [page-name params]
  (case page-name
    :home [home]
    :about [about]
    :topics [topics]
    :topic [topic params]
    :counter [counter]
    [home]))

(defn app
  []
  (let [active-page (rf/subscribe [:active-page])]
   (fn
     []
     [:div
      [header]
      [pages @active-page]])))
