# -*- coding: utf-8 -*-
import re
from pymongo import MongoClient
import unicodedata
import json
import requests

client = MongoClient('localhost', 27017)

db = client.indeed_broker
collection = db.indeed_new_prod

# list_url =[]
regex = r"((http|https):\/\/)?www.indeed.com\/rc\/(.*)"

count = 0
for doc in collection.find():

    if "docid" in doc.keys():
        print(doc['docid'])
        print("tt")
        collection.update({"_id": doc['_id']}, {"$set": {"docid": str(count)}})
        count=count+1
    else:
        http_code = requests.get(doc['url']).status_code
        if http_code == 200:
            collection.update({"_id": doc['_id']}, {"$set": {"docid": str(count)}})
            # print(http_code)
            count=count+1
        else:
            print(doc['_id'])
            collection.remove({"_id": doc['_id'] })
            pass




# start_urls = [url.strip() for url in list_url]

# def parse(self, response):
#     jobtitle = response.xpath('//*[@class="jobtitle"]/font/text()').extract_first()
#     company =response.xpath('//*[@class="company"]/text()').extract_first()
#     job_summary = response.xpath('//*[@id="job_summary"]').extract()
#     location = response.xpath('//*[@class="location"]/text()').extract_first()
#     canonical = response.xpath('//link[@rel="canonical"]').extract_first()
#     url = "https://www.indeed.com/"+canonical

#     str = ''.join(job_summary)
#     p = re.compile(r'<.*?>')
#     job_nohtml = p.sub(' ',str)
#     job_nounicode = unicodedata.normalize('NFKD', "".join(job_nohtml)).encode('ascii','ignore').decode("utf-8") 
#     yield {'Job Title': jobtitle, 'Company': company, 'Location': location, 'Summary': job_nounicode, 'url': url} 
