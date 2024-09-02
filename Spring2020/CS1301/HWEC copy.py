# part 1
def tiktok(sound):
    final=[]
    real=[]
    for i in sound:
        if i==[]:
            continue
        n=[]
        for j in i:
            n.append(j[1])
        m=max(n)
        for k in i:
            if k[1]==m:
                final.append((k[1],k[0]))
    
    final=sorted(final,reverse=True)
    for l in final:
        real.append((l[1],l[0]))
    return real

# part 2
def notepassing(message,kw):
    if message=='':
        return False
    if len(kw)==1:
        return True
    elif message[len(message)-1]==kw[0]:
        notepassing(message[:(len(message))-1],kw[1:])
        return True
    else:
        return False

# part 3
def scavengerhunt(pov,peo):
    final={}
    n=0
    for tofp in peo:
        if tofp[1]==[]:
            final[tofp[0]]=0
            continue
        for li in tofp[1]:
            for inf in pov:
                if li==inf[0]:
                    n=n+inf[1]
            final[tofp[0]]=n
        n=0
    return final
    
# part 4
def drawConstellations(rows,space):
    if rows==0:
        print('')
    elif rows==1:
        print(' '*space+'*')
    else:
        print (' '*space+'*'*(2*rows-1))
        drawConstellations(rows-1,space+1)

#part 5
class Sandwich:
    def __init__(self,sauces=[],veggies=[],cheese=0,breadSlices=2):
        self.sauces= sauces
        self.veggies = veggies
        self.cheese = cheese
        self.breadSlices = breadSlices

    def __eq__(self,other):
        n=0
        for i in self.veggies:
            if i in other.veggies:
                n+=1
        if n==len(self.veggies):
            return True
        return self.veggies==other.veggies and self.breadSlices==other.breadSlices
    

    def addVeggie(self,ve):
        if ve in self.veggies:
            self.cheese+=1
        else:
            self.veggies.append(ve)

    def merge(sandwich1,sandwich2):
        s=[]
        v=[]
        b=0
        b=(sandwich1.breadSlices+sandwich2.breadSlices)//2
        s=s+sandwich1.sauces
        for i in sandwich2.sauces:
            if i in s:
                continue
            else:
                s.append(i)
        v=v+sandwich1.veggies
        for j in sandwich2.veggies:
            if j in v:
                continue
            else:
                v.append(j)
        return (s,v,2,b)

