#set functions for each variable
#4 variables for function 1
def calorie_count():
      ham_count = input("How many hamburgers would you like?")
      fries_count = input("How many orders of french fries would you like?")
      carrot_count = input("How many carrot sticks would you like?")
      walk_min = input("How many minutes did you walk?")
      print("{}".format(ham_count), "hamburgers,", "{}".format(fries_count), "orders of french fries,", "{}".format(carrot_count), "carrot sticks, and", "{}".format(walk_min), "minutes walked is", 400*int(ham_count)+200*int(fries_count)+25*int(carrot_count)-5*int(walk_min), "calories.")
#calorie_count()

#2 variables for function 2
def cone_volume():
      height = input("What is the height of the cone?")
      radius = input("What is the radius of the cone?")
      volume = 3.1415926*float(radius)**2*float(height)/3
      volume = round(volume, 2)
      print("The volume of a cone with a height of {}".format(float(height)), "and a radius of {}".format(float(radius)), "is {}".format(volume)+".")
#cone_volume()

#2 variables for function 3
def watch_time():
      movies = input("How many movies have you watched?")
      tv = input("How many TV show episodes have you watched?")
      #calculate hours
      hour = (int(movies)*110+int(tv)*25)//60
      #calculate minutes
      minute = int(movies)*110+int(tv)*25-hour*60
      print("By watching {}".format(movies), "movies and {}".format(tv), "TV show episodes, you have spent", hour, "hour(s) and", minute, "minutes on Disney+.")
#watch_time()

#1 variable for function 4
def liquid_conversion():
      water = input("How many cups of water did you drink?")
      #calculate gallon
      gallon = int(water)//16
      #calculate quart
      quart = (int(water)-int(gallon)*16)//4
      #calculate pint
      pint = (int(water)-int(gallon)*16-int(quart)*4)//2
      #calculate cup
      cup = int(water)-int(gallon)*16-int(quart)*4-int(pint)*2
      print("You drank {}".format(gallon), "gallon(s), {}".format(quart), "quart(s), {}".format(pint), "pint(s), and {}".format(cup), "cup(s) of water.")
#liquid_conversion()

#3 variables for function 5
def savings_calculator():
      principal = input("What is the principal?")
      rate = input("What is the interest rate?")
      month = input("How many months have passed?")
      total = float(principal)*(1+(float(rate)/100)*(float(month)/12))
      total = round(total, 2)
      print("You will have ${}".format(total), "at the end of {}".format(month), "months.")
#savings_calculator()
