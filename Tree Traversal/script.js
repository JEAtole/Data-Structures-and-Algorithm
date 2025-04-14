
let order = [];
const button = document.querySelectorAll('button');

const getTreeData = () => {
    return {
        data: 'A',
        left: {
            data: 'B',
            left: {
                data: 'D',
                left: {
                    data: 'H'
                },
                right: {
                    data: 'I'
                },
            },
            right: {
                data: 'E',
            }
        },
        right: {
            data: 'C',
            left: {
                data: 'F'
            },
            right: {
                data: 'G',
                left: {
                    data: 'J'
                },
                right: {
                    data: 'K'
                }
            }
        }
    }
}

const generateTree = (node) => {
    const { data, left, right } = node;
    return `
        <div class="node_data" name=${data}>${data}</div>
        ${left || right ? `
            <div class="vertical_line"></div>
            <div class="bottom_line"></div>
            <div class="node_children">
                ${left ? `
                    <div class="node node--left">
                    <div class="vertical_line"></div>
                        ${generateTree(left)}
                    </div>
                    ` : ''
            }
                ${right ? `
                    <div class="node node--right">
                        <div class="vertical_line"></div>
                        ${generateTree(right)}
                    </div>
                ` : ''}
                </div>
            ` : ''
        }   
    `
}

const main = () => {
    const nodes = getTreeData();
    const treeComponent = document.querySelector('.tree');
    treeComponent.innerHTML = generateTree(nodes);
};

const traversalAnimation = (method) => {
    order = [];
    main();
    clearBox('.answer');
    traversal(method);
    button.forEach(element => {
        element.disabled = false;
    });
    animation();

}

const traversal = (method) => {
    const nodes = getTreeData();
    switch (method) {
        case 'preOrder':
            preOrder(nodes);
            break;
        case 'inOrder':
            inOrder(nodes);
            break;
        case 'postOrder':
            postOrder(nodes);
            break;
    }
}

async function animation () {
        for (let i=0; i<order.length; i++) {
            const data = order[i];
            const selector = `[name='${data}']`;
            const element = document.querySelector(selector);
            const textArea = document.querySelector('.answer');
            var paragraph = document.createElement("p");
            paragraph.textContent = data;
            textArea.append(paragraph);
            element.classList.toggle("change");
            await sleep(1000);
        } 
}

function clearBox(className)
{
    document.querySelector(className).innerHTML = "";
}

function sleep(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
  }

const preOrder =  (node) => {
    if (node == null)
        return;

    order.push(node.data);
    preOrder(node.left);
    preOrder(node.right);

}

const inOrder = (node) => {
    if (node == null)
    return;

    inOrder(node.left);
    order.push(node.data);
    inOrder(node.right);
}

const postOrder = (node) => {
    if (node == null)
    return;

    postOrder(node.left);
    postOrder(node.right);
    order.push(node.data);
}

main();
