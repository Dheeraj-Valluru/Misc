#XML elements

# <people> #start tag
#   <person>
#     <name>Chuck</name> #text context is 'Chuck'
#     <phone>303 4456</phone>
#   </person>
#   <person>
#     <name>Noah</name>
#     <phone>622 7421</phone>
# </people> #end tag

#meant to be able to share structured data
#simplified version of SGML

#html has set tags but here (xml) we can make personalized tags

import xml.etree.ElementTree as ET
data = '''<person>
  <name>Chuck</name>
  <phone type = "intl">
    +1 734 303 4456
  </phone>
  <email hide = "yes"/>
</person>'''

tree = ET.fromstring(data)
print('Name:', tree.find('name').text)
print('Attr:', tree.find('email').get('hide'))
