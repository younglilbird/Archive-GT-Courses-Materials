#function 1

def stringMultiply(sentence, num):
    num = int(num)
    number = 0
    product = 1
    first = 1
    keep =0
    for word in sentence:
        if str.isdigit(word):
            number += 1
            product = product * int(word)
        else:
            number +=0
    for word in sentence:
        if str.isdigit(word) and num <= number:
            first = first * int(word)
            keep +=1
            if keep < num:
                continue
            if keep>= num:
                break
    if num == 0:
        return 0
    elif num > 0 and number == 0:
        return 1
    elif num > number:
        return product
    elif num <= number:
        return first
    
#function 2
def longestWord(sentence):
    long = ""
    temp = ""
    for letter in sentence:
        if letter != " ":
            temp += letter
        if letter == " ":
            if len(temp) >=len(long):
                long = temp
            temp = ""
    return long
           


#function 3
def drawTriangle(height):
    height = int(height)
    num = 1
    while num <= height:
        print((str(num) +" ") *(num-1)+str(num))
        num +=1

#function 4
def populationGrowth(start, rate, end):
    start = int(start)
    rate = float(rate)
    end = int(end)
    year = 0
    while start <= end:
        start = (1+rate/100)*start
        year += 1
    return year

#function 5
def marta(path, start, stop):
    road = False
    count = 0
    if start == stop:
        return 0
    for word in path:
        if start == word:
            road = True
        if word == stop:
            road = False
        if road == True and word == "-":
            count += 1
        else:
            count = count
    return count
