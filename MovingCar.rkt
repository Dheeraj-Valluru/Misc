;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname MovingCar) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp")) #f)))
(define width-of-world 200)
(define wheel-radius 2)
(define wheel-distance (* wheel-radius 5))
(define wheel
  (circle wheel-radius "solid" "black"))
(define spacer
  (rectangle (* wheel-radius 3) wheel-radius "solid" "white"))
(define both-wheels
  (beside wheel spacer wheel))
(define car-body
  (above (rectangle (* wheel-radius 5.5) 5 "solid" "red")
         (rectangle (* wheel-radius 11.75) 5 "solid" "red")))
(define red-car
  (above car-body
         both-wheels))
(define background
  (empty-scene width-of-world 40))


; A worldstate is a number
; interpretation the number of pixels between the left bordr of the scene and the car

;WorldState -> Image
;places the image of car x pixels from the left margin of the backgroud image
(define (render x)
  (overlay/offset red-car
                  (- 77 x) -10
                  background))

;WorldState -> WorldState
;adds 3 to x to move the car right
(define (tock x)
  (+ x 3))

;WorldState -> WorldState
;luanches the program
(define (main ws)
  (big-bang ws
    [on-tick tock]
    [to-draw render]))
