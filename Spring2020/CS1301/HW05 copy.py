# function 1
def summer_job(jobs):
    pay = 0
    final = ""
    for i in jobs:
        if float(i[1]) * int(i[2]) > pay:
            pay = float(i[1]) * int(i[2])
            final = i[0]
    return final

# function 2
def wasted_food(foodlist):
    left = 0
    rate = 100
    purchase =0
    no =0
    for i in foodlist:
        if str(i[0]).isdigit() == False:
            continue
        if int(i[1])/int(i[0])*100 < rate:
            rate = int(i[1])/int(i[0])*100
            left = i[1]
            purchase = i[0]
        elif int(i[1])/int(i[0])*100 == rate:
            if i[1] <left:
                rate = int(i[1])/int(i[0])*100
                left = i[1]
                purchase = i[0]
    for a in foodlist:
        if a != (int(purchase), int(left)):
            no+=1
        else:
            break
    return (foodlist[0][no-1], round(rate,2))

# function 3
def ancestors(names, surname):
    namelist=[]
    for i in names:
        ok = i.split(" ")
        if len(ok) ==2 and ok[1] == surname and ok[0] not in namelist:
            namelist.append(ok[0])
    return namelist

# function 4
def trigonometry(degree, ope):
    import math
    angle =""
    for i in degree:
        if i != "°":
            angle+=i
    angle = float(angle)
    angle = angle/180*math.pi
    if ope == "cosine":
        angle = math.cos(angle)
    if ope == "sine":
        angle = math.sin(angle)
    if ope =="tangent":
        angle = math.tan(angle)
    angle = round(angle,2)
    return angle

# function 5
def days_of_the_week(birthdays, year):
    import calendar
    name = []
    for i in birthdays:
        if calendar.weekday(year,i[1],i[0])==4 or calendar.weekday(year,i[1],i[0])==5:
            name.append(i[2])
    return name
    
# function 6
def conversion(aStr):
    aStr = aStr[1:]
    final = float(aStr)
    return final

def donation_amount(donation):
    total = 0
    for i in donation:
        i = conversion(i)
        total +=i
    return total
    
