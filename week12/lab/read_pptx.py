import zipfile
import xml.etree.ElementTree as ET
import sys

def extract_text_from_pptx(pptx_path):
    try:
        text_runs = []
        with zipfile.ZipFile(pptx_path) as pptx:
            for name in pptx.namelist():
                if name.startswith('ppt/slides/slide') and name.endswith('.xml'):
                    xml_content = pptx.read(name)
                    tree = ET.XML(xml_content)
                    
                    # Namespace for drawingml
                    a_schema = '{http://schemas.openxmlformats.org/drawingml/2006/main}'
                    
                    for node in tree.iter(a_schema + 't'):
                        if node.text:
                            text_runs.append(node.text)
            
            return '\n'.join(text_runs)
    except Exception as e:
        return str(e)

if __name__ == '__main__':
    text = extract_text_from_pptx(sys.argv[1])
    with open('pptx_output.txt', 'w', encoding='utf-8') as f:
        f.write(text)
