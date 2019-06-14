(ns understanding-re-frame.hiccup
  (:require [reagent.core :as reagent]
            [clojure.string :as str]))

(defn cs [& args]
  (str/join " " (map name (filter identity args))))

(defn subcomponent [txt]
     [:div.wrapper
      {:style {:width 100}
       :on-click (fn [e]
                   (js/console.log "Wrapper Div"))}
      ;js/console.log == println
      [:div.container>div.inner
       ;synsug for nested divs/elements
       [:p "nothing"]
       [:p txt]]]
  )


(defn hiccup-panel []
  (let [title "hello from the other side"
        border-color "pink"
        active? true]

    [:div#main-content.content.row
     {:class (when active? "active")
      :style {:padding-left 20
              :border (when border-color
                        (str "20px solid " border-color))}}

     [:h1#hiccup.big.centered "DID YOU KNOW?"]
     [subcomponent "this is an arg"]
     ; call subcomponent in [] to use it as a react component, otherwise it wont call again 
     [:p.first-paragraph.bold-text
      "yorkie are bread, to sleep at your"]
     [:input {:type    :checkbox
              :checked false}]
     [:p "focaccia"]
     [:p
      {:on-click (fn [e]
                  (println "paragraph"))}
      [:a {:href "www.google.com"
              :on-click
                    (fn [e]
                      (.preventDefault e)
                      (.stopPropagation e)
                      ; stopP will stop the element from "bubbling up" and putting into motion other events
                      (println "link"))} "google it"]]
     [:p "....." [:b "at the foot of your baguette"]]]))


