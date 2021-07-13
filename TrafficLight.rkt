;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname TrafficLight) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp")) #f)))
;TrafficLight->TrafficLight
;yields the next light change a traffic light makes
(define (traffic-light-next L)
  (cond
    [(string=? "red" L) "green"]
    [(string=? "yellow" L) "red"]
    [(string=? "green" L) "yellow"]
    [else "Please enter a valid light: green, yellow, or red"]))

