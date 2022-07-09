text = "X-DSPAM-Confidence:    0.8475"
startOfNum = text.find("0")
endOfText = len(text)
num = float(text[startOfNum:endOfText])
print(num)
