#part 1
import requests
def cookFast(name,minute):
    n=[]
    baseurl= 'https://api.spoonacular.com/recipes/search?query='
    full=baseurl+name+'&apiKey=b30d0988e2a14793b784cadfcacff8a7'
    r=requests.get(full)
    data=r.json()
    for i in data['results']:
        if i['readyInMinutes']<minute and i['servings']>=4:
            n.append(i['title'])
    return n

#part 2
def nutrients(nut, mini, maxi):
    n=[]
    baseurl='https://api.spoonacular.com/recipes/findByNutrients?'
    full=baseurl+'min'+nut+'='+str(mini)+'&max'+nut+'='+str(maxi)+'&apiKey=b30d0988e2a14793b784cadfcacff8a7'
    r=requests.get(full)
    data=r.json()
    for i in data:
        n.append(i['title'])
    return n

#part 3
def groceryTime(rid, li):
    final={}
    baseurl='https://api.spoonacular.com/recipes/'
    full=baseurl+str(rid)+'/information?apiKey=b30d0988e2a14793b784cadfcacff8a7'
    r=requests.get(full)
    data=r.json()
    for i in data['extendedIngredients']:
        if i['name'] not in li:
            if i['aisle'] not in final.keys():
                final[i['aisle']]=[]
                final[i['aisle']]=final[i['aisle']]+[(i['name'],i['measures']['us']['amount'])]
            else:
                final[i['aisle']]=final[i['aisle']]+[(i['name'],i['measures']['us']['amount'])]
    return final



#part 4
def animalPopulation(maximum):
    n=[]
    baseurl='http://www.bloowatch.org/developers/json/species'
    r=requests.get(baseurl)
    data=r.json()
    for i in data['allSpecies']:
        if i['population'] == 'unknown':
            continue
        if '-' in i['population']:
            re= i['population'][:i['population'].index('-')-1]
            re=re.replace(',','')
            if int(re)<maximum:
                n.append((i['name'],int(re)))
        elif int(i['population'].replace(',',''))<maximum:
            n.append((i['name'], int(i['population'].replace(',',''))))
    return n

#part 5
def encyclopedia(level):
    if (level== 'Vulnerable' or level=='Endangered' or level=='Critically Endangered') == False:
       return None
    n={}
    baseurl='http://www.bloowatch.org/developers/json/species'
    r=requests.get(baseurl)
    data=r.json()
    for i in data['allSpecies']:
        if i['status']==level:
            des=i['description'].split('.')
            real=des[0]+'.'
            n[i['name']]=real
    return n
