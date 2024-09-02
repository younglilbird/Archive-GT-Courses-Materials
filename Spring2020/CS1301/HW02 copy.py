#function 1
#3 variables
def co2emissions(trolleys, buses, cars):
    trolleys = int(trolleys)
    buses = int(buses)
    cars = int(cars)
    total = trolleys * 233 + buses * 299 + cars * 371
    if total <= 250:
        return("Great")
    elif total <1000:
        return("Not Good")
    else:
        return("Bad!!")

#function 2
#3 variables
def supportRally(yes, no, degree):
    yes = float(yes)
    no = float(no)
    degree = str(degree)
    a = (1-no) * yes
    if degree == "Outstanding support":
        b = (0.9-a)/no*100
        if b<=100:
            return round(b,2)
        else:
            return ("Not Possible")
    elif degree == "Significant support":
        c = (0.8-a)/no*100
        if c<=100:
            return round(c,2)
        else:
            return("Not Possible")
    else:
        d = (0.7-a)/no*100
        if d<=100:
            return round(d,2)
        else:
            return("Not Possible")

        


#function 3
#4 variables
def isRallySuccessful(level, yes,no, degree):
    yes = float(yes)
    no = float(no)
    level = int(level)
    degree = str(degree)
    a = (1-no) * yes
    if degree == "Outstanding support":
        b = (0.9-a)/no*100
        if b<=100 and level > 6:
            return True
        else:
            return False
    elif degree == "Significant support":
        c = (0.8-a)/no*100
        if c<=100 and level > 6:
            return True
        else:
            return False
    else:
        d = (0.7-a)/no*100
        if d<=100 and level > 6:
            return True
        else:
            return False

#function 4
#2 variables
def spreadingFire(miles, limit):
    over = int(miles)-int(limit)
    level = over//100
    if level<=0:
        if level<0:
            return("Danger Level: 0; Proceed with caution")
        else:
            return("Danger Level: "+str(level)+"; Proceed with caution")
    elif level<=4:
        return("Danger Level: "+str(level)+"; Firebreak and Airdrop")
    else:
        return("Danger Level: "+str(level)+"; Evacuate and Full Protocol")

#function 5
#4 variables
def recycle(soda, grocery, fork, cap):
    soda =int(soda)
    grocery =int(grocery)
    fork =int(fork)
    cap =int(cap)
    weight_soda =soda*37.3
    weight_grocery =grocery*5
    weight_pp = fork*2.5+cap*2.4
    pete =soda
    hdpe =grocery*2
    pp =fork*5+cap*5
    red_bag =0
    yellow_bag =0
    green_bag =0
    if weight_soda <60:
        red_bag =red_bag+soda
    elif weight_soda>60 and pete<5:
        green_bag =green_bag+soda
    elif weight_soda>60 and pete>5:
        yellow_bag =yellow_bag+soda
    yellow_bag =yellow_bag+grocery
    if weight_pp <60:
        yellow_bag =yellow_bag+fork+cap
    elif weight_pp >60 and pp>10:
        green_bag =green_bag+fork+cap
    elif weight_pp >60 and pp<10:
        red_bag =red_bag+fork+cap
    return("Green:"+str(green_bag)+", Yellow:"+str(yellow_bag)+", Red:"+str(red_bag))
        



    
    
