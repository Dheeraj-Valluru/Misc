;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ufoLanding) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp")) #f)))
;A WorldState is a Number
;interpretation number of pixels between the top and the UFO

(define width 300)
(define height 100)
(define eye-radius 2)
(define eye-distance
  (* eye-radius 2))
(define spacer
  (rectangle eye-distance eye-radius "solid" "green"))
(define eye
  (circle eye-radius "solid" "black"))
(define both-eyes
  (beside eye spacer eye))
(define mtscn (empty-scene width height))
(define ufo (overlay both-eyes (circle 10 "solid" "green")))

;WorldState->image
;puts ufo x pixels from top of mtscn
(check-expect (render 0) (overlay/offset both-eyes 8 50 mtscn))
(define (render y)
  (overlay/offset both-eyes 8 (- 50 y) mtscn))

;WorldState->WorldState
;adds 2 to x to move the car down
(check-expect (tock 11) 13)
(define (tock y)
  (+ y 2))

;WorldState->WorldState
(define (main y0)
  (big-bang y0
    [on-tick tock]
    [to-draw render]))

