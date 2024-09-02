#function 1

def messageEncoder(string):
    i = 1
    new = ""
    if string == "":
        return None
    string = string.split(" ")
    for word in string:
        if i % 2 == 1 and i == len(string):
            word = word.upper()
            new = new + word
        elif i % 2 == 0 and i == len(string):
            word = word.lower()
            new = new + word
        elif i % 2 == 1:
            word = word.upper()
            new = new + word + " "
        elif i % 2 == 0:
            word = word.lower()
            new = new+word+ " "
        i +=1
    return new
    
#function 2

def courseCreator(courseslist):
    if courseslist == []:
        return None
    average = "0"
    temp = ""
    title = ""
    for course in courseslist:
        for element in course:
            if element.isdigit() == True:
                temp += element
        average = int(average) + int(temp)
        temp = ""
    for element in course:
        if element.isdigit() == False:
            title += element
        if element.isdigit() == True:
            break
    average = average/len(courseslist)
    average = int(average)
    return title+str(average)

#function 3

def compoundWords(wordlist, number):
    if wordlist == []:
        return None
    new = []
    for word in wordlist:
        if len(word) < number:
            for i in wordlist:
                if len(i) == number-len(word) and i != word and wordlist.index(i)>wordlist.index(word):
                    new= new+[(word+i)]
    return new

#function 4

def noteTaker(note):
    new = ""
    for num in range(len(note)):
        if num == len(note)-1:
            new = new + note[len(note)-1]
        elif note[num] in ".,?!@:" and note[num+1] == " " and note[num+2].isupper() == True:
            new += note[num]
        elif note[num] in ".,?!@:":
            continue
        else:
            new += note[num]
    return new

#function 5

def foodDesertLocator(cities):
    average = 0
    city =[]
    for i in cities:
        if cities.index(i) % 2 ==1:
            average += i
    average = average/(len(cities)//2)
    index=0
    for u in cities:
        if index %2==1 and u>average:
            city = city + [cities[index-1]]
        index+=1
    return city
