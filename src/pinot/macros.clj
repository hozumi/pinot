(ns pinot.macros)

(defmacro defpartial
  [name params & body]
  `(defn ~name ~params
     (pinot.html/html
       ~@body)))

(defmacro defelem
  "Defines a function that will return a tag vector. If the first argument
  passed to the resulting function is a map, it merges it with the attribute
  map of the returned tag value."
  [name & fdecl]
  `(let [func# (fn ~@fdecl)]
    (def ~name (pinot.html.tags/add-optional-attrs func#))))
