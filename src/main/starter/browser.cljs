(ns starter.browser
  (:require [rum.core :as rum]))


(rum/defc page-title [text]
  [:h1 (str "Hello nice  cool beans" text)])

(defn render-stuff []
  (rum/mount (page-title "abc nice") (.getElementById js/document "app")))


;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (render-stuff))


(defn init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (render-stuff))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))
