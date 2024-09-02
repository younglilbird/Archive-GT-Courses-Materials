# part 1
class Tweet:
    def __init__(self,message='',hashtags=(),likes=0,retweets=0):
        self.message=message
        self.hashtags=hashtags
        self.likes=likes
        self.retweets=retweets

    def is_trending(self,like,re):
        if self.likes>like and self.retweets>re:
            return True
        else:
            return False

    def __str__(self):
        return 'Message: '+self.message+', Hashtags: '+str(self.hashtags)

    def __eq__(self, other):
        return self.message==other.message and self.hashtags==other.hashtags

class Account:
    def __init__(self,username,password):
        self.username=username
        self.password=password
        self.tweets=[]
        
    def change_password(self,old,new):
        if old != self.password:
            return "Passwords don't match"
        elif new == self.password:
            return "New password must be different"
        else:
            self.password=new
            return 'Successfully changed passwords'
        
    def is_famous(self):
        n=0
        for t in self.tweets:
            if t.is_trending(100000,75000) == True:
                n+=1
        if n>=5:
            return True
        else:
            return False
        
    def __lt__(self, other):
        n=0
        m=0
        for i in self.tweets:
            n+=i.likes
        for j in other.tweets:
            m+=j.likes
        if n<m:
            return True
        else:
            return False

    def __eq__(self1,self2):
        return self1.username==self2.username and self1.password==self2.password

class Twitter:
    def __init__(self,followers={},following={}):
        self.accounts=[]
        self.followers=followers
        self.following=following
        self.tweets=[]

    def register(self,username,password):
        if username=='ThisUsernameExist':
            return 'Username is already taken!'
        else:
            self.followers[username]=[]
            self.following[username]=[]
            self.accounts.append((username,password))
            return [username,password]
    def follow(self,account1,account2):
        if account2.username in self.followers != True:
            self.followers[account2.username]=self.following
            self.following[account1.username]=self.followers

    def delete_account(self, account):
        if account.username in self.accounts:
            self.accounts.remove(account.username)
            self.followers.remove(account.username)
            self.following.remove(account.username)

    def tweet(self, accounts, message, hashtag):
        if len(message)>25:
            return 'The length of the message must be <=25'
        else:
            self.tweets.append((message,hashtag))
    def get_famous(self):
        n=[]
        for i in self.accounts:
            if i.is_famous:
                n.append(i.username)
        return n
